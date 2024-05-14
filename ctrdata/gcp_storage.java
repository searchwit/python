public class CloudStorageHelper {

  private final Logger logger = Logger.getLogger(CloudStorageHelper.class.getName());
  private static Storage storage = null;

  static {
    storage = StorageOptions.getDefaultInstance().getService();
  }


  /**
   * Uploads a file to Google Cloud Storage to the bucket specified in the BUCKET_NAME environment
   * variable, appending a timestamp to end of the uploaded filename.
   */
  public String uploadFile(FileItemStream fileStream, final String bucketName)
      throws IOException, ServletException {
    checkFileExtension(fileStream.getName());

    System.out.println("FileStream name: " + fileStream.getName() + "\nBucket name: " + bucketName);

    DateTimeFormatter dtf = DateTimeFormat.forPattern("-YYYY-MM-dd-HHmmssSSS");
    DateTime dt = DateTime.now(DateTimeZone.UTC);
    String dtString = dt.toString(dtf);
    final String fileName = fileStream.getName() + dtString;

    // the inputstream is closed by default, so we don't need to close it here
    @SuppressWarnings("deprecation")
    BlobInfo blobInfo =
        storage.create(
            BlobInfo.newBuilder(bucketName, fileName)
                // Modify access list to allow all users with link to read file
                .setAcl(new ArrayList<>(Arrays.asList(Acl.of(User.ofAllUsers(), Role.READER))))
                .build(),
            fileStream.openStream());
    logger.log(
        Level.INFO, "Uploaded file {0} as {1}", new Object[] {fileStream.getName(), fileName});
    // return the public download link
    return blobInfo.getMediaLink();
  }


  /** Checks that the file extension is supported. */
  private void checkFileExtension(String fileName) throws ServletException {
    if (fileName != null && !fileName.isEmpty() && fileName.contains(".")) {
      String[] allowedExt = {".jpg", ".jpeg", ".png", ".gif"};
      for (String ext : allowedExt) {
        if (fileName.endsWith(ext)) {
          return;
        }
      }
      throw new ServletException("file must be an image");
    }
  }
}


