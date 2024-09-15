package utilities;




import org.apache.commons.compress.utils.FileNameUtils;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.*;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecord {

  public static final String USER_DIR = "user.dir";
  public static final String DOWNLOADED_FILES_FOLDER = "downloads";
  private ScreenRecorder screenRecorder;
  private File file =
          new File(System.getProperty(USER_DIR) + File.separator + DOWNLOADED_FILES_FOLDER);

  public void startRecording() throws Exception {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screenSize.width;
    int height = screenSize.height;

    Rectangle captureSize = new Rectangle(0, 0, width, height);

    GraphicsConfiguration gc = GraphicsEnvironment
      .getLocalGraphicsEnvironment()
      .getDefaultScreenDevice()
      .getDefaultConfiguration();

    this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
        new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
        new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
            ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey,
            ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey, Rational.valueOf(15),
            QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
        new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey,
            Rational.valueOf(30)),
        null, file, "AutomationVideo");
    this.screenRecorder.start();

  }

  public void stopRecording() throws Exception {

    File output = null;

    this.screenRecorder.stop();
    output = new File(System.getProperty("user.dir") + "\\files\\local.avi");

    System.out.println("Video output file: " + output);

    final File[] files = file.listFiles();

    if (files != null) { // some JVMs return null for empty dirs
      for (File f : files) {
        if (FileNameUtils.getExtension(f.getName()).contains("avi")) {
          copyFileUsingStream(f, output); // can take a long time

        }
        f.delete();
      }
    }

  }

  private void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
      is = new FileInputStream(source);
      os = new FileOutputStream(dest);
      byte[] buffer = new byte[1024];
      int length;
      while ((length = is.read(buffer)) > 0) {
        os.write(buffer, 0, length);
      }
    } finally {
      is.close();
      os.close();
    }
  }

}
