for(File fileEntry : sourceFolder.listFiles()) {

  String path = fileEntry.getName();
  String ext = Files.getFileExtension(path);
  if ("xml".equalsIgnoreCases(ext)) {

     ackLoad(fileEntry.getAbsolutePath());
     java.nio.file.Files.move(Paths.get(fileEntry.getPath()), 
 Paths.get(targetFolder + fileEntry.getName), StandardCopyOption.replaceExsiting
  
