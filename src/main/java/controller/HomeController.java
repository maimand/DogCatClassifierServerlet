package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Bean.User;
import thread.VGG16;

@WebServlet("/")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VGG16 vgg16;

	public HomeController() {
		this.vgg16 = VGG16.getVGG16();
		System.out.println("Home");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/login");
		} else {
			response.sendRedirect("Home.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO: Upload file
		String fileName = "";
		for (Part part : request.getParts()) {
			fileName = extractFileName(part);
			// refines the fileName in case it is an absolute path
			fileName = new File(fileName).getName();
			part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
		}
		System.out.println(this.getFolderUpload().getAbsolutePath() + "\\" + fileName);
		System.out.println("Uploaded");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		this.vgg16.predict(user.userId, getFolderUpload().getAbsolutePath() +File.separator+ fileName);

		// TODO: Handle recognition and add to history

		response.sendRedirect("Home.jsp");

	}

	/**
	 * Extracts file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	public File getFolderUpload() {
		File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}

}
