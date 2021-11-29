import java.io.File;

import model.BO.HistoryBO;
import model.BO.LoginBO;
import thread.VGG16;

public class Test {
	public static void main(String[] args) {
//		LoginBO loginBO = new LoginBO();
//	    int userId1 = loginBO.checkLogin("admin","password");
//	    System.out.println(userId1);
//		VGG16 vgg16 = VGG16.getVGG16();
//		File imageFile = new File("dog2.jpg");
//		vgg16.predict(imageFile);
		HistoryBO historyBO = new HistoryBO();
		historyBO.addHistoryRecord("hello", null, 0);
		}
}
