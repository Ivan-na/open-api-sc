package com.moma.zoffy.wapper;

import com.google.common.base.Throwables;
import com.moma.zoffy.helper.JacksonHelper;
import com.moma.zoffy.response.dto.ApiStatusInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MimeTypeUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * ResponseWrapper
 *
 * <p>Response Wrapper
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/14/18 - 7:51 PM.
 */
@Slf4j
public class ResponseWrapper extends HttpServletResponseWrapper {
  private ApiStatusInfo apiStatusInfo;

  public ResponseWrapper(HttpServletResponse response) {
    super(response);
  }

  public ResponseWrapper(HttpServletResponse response, ApiStatusInfo apiStatusInfo) {
    super(response);
  }

    /**
     * @param obj :
     * @return void
     * @author Created by ivan on 3:44 PM 12/24/18.
     * <p>//write Response back as Json
     */
    public void writeJsonResponse(Object obj) {
        if (super.isCommitted()) {
            log.warn("Response is commit");
        } else {
            super.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
            super.setCharacterEncoding(StandardCharsets.UTF_8.name());
            try (PrintWriter writer = super.getWriter()) {
                writer.print(JacksonHelper.toJson(obj));
                writer.flush();
            } catch (IOException e) {
                log.warn(
                        "Error: Response print Json faild, stackTrace: {}",
                        Throwables.getStackTraceAsString(e));
            }
        }
    }
}
