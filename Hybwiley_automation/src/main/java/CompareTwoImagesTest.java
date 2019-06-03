import java.io.IOException;


public class CompareTwoImagesTest {
	public static void main(String[] args) throws IOException {
		
		// insert into CompareTwoImages constructor valid paths of yours image files
		// considering system environment
		// for Windows7 make sure that you have access for reading from concrete folders and writing into concrete folders
		CompareTwoImages cti = new CompareTwoImages("C:\\Users\\apsinha\\Pictures\\wip.jpg", "C:\\Users\\apsinha\\Pictures\\uat.jpg");
		cti.setParameters(30, 30);
		cti.compare();
		if (!cti.isIdentic()) {
			System.out.println("no match");
			CompareTwoImages.saveJPG(cti.getImageResult(), "C:\\Users\\apsinha\\Pictures\\output.jpg");
		} else {
			System.out.println("match");
		}
	}
}
