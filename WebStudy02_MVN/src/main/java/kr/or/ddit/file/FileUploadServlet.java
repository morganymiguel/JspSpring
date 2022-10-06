package kr.or.ddit.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

@WebServlet("/file/upload.do")
public class FileUploadServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tmpDir = "D:\\temp";
		DiskFileItemFactory itemFactory = new DiskFileItemFactory(10*1024, new File(tmpDir));
		ServletFileUpload uploadHandler = new ServletFileUpload(itemFactory);
		try {
			List<FileItem> parts = uploadHandler.parseRequest(req);
			String encoding = req.getCharacterEncoding();
			Map<String, Object> model = new HashMap<>();
			for(FileItem part : parts) {
				String partName = part.getFieldName();
				if(part.isFormField()) {
					String parameter = part.getString(encoding);
					model.put(partName, parameter);
				}else {
					String savePath = uploadFile(part);
					model.put(partName, savePath);
				}
			}
			req.getSession().setAttribute("model", model);
			resp.sendRedirect(req.getContextPath() + "/12/uploadForm.jsp");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	private String uploadFile(FileItem part) throws IOException {
		String saveFolderURL = "/resources/prodImages";
		ServletContext application = getServletContext();
		String saveFolderPath = application.getRealPath(saveFolderURL);
		String filename = part.getName();
		File saveFile = new File(saveFolderPath, filename);
		try(
			InputStream is = part.getInputStream();
		){
			FileUtils.copyInputStreamToFile(is, saveFile);
			return saveFolderURL + "/" + saveFile.getName();
		}
	}
}















