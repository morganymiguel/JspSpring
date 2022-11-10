package kr.or.ddit.alba.view;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.vo.LicenseVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LicenseImageView extends AbstractView {
	
	@Value("#{appInfo['profile.image']}")
	private File saveFolder;
	
	@Value("#{appInfo['noImage.path']}")
	private Resource noImage;
	
	@PostConstruct
	public void init() throws IOException {
		log.info("attatch file path : {}", saveFolder.getCanonicalPath());
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse resp) throws Exception {
		LicenseVO license = (LicenseVO) model.get("license");
		resp.setContentType("application/octet-stream");
		byte[] imageData = license.getLicImg();
		try(
			InputStream is = imageData==null ? noImage.getInputStream() : new ByteArrayInputStream(imageData);
			OutputStream os = resp.getOutputStream();	
		){
			IOUtils.copy(is, os);
		}
	}

}
