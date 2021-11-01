public boolean xyzThere(String str) {
  if (str.length() > 3) {
    if (((str.substring(0, 4)).equals("xyz")))  {
    return true;
    }
  }
  if (str.length() == 3) {
    if (((str.substring(0)).equals("xyz")))  {
    return true;
    }
  }
  for (int i = 0; i < str.length()-3; i++) {
    if ((((str.substring(i, i+1)).equals(".")) == false) && ((str.substring(i+1, i+4)).equals("xyz")))  {
      return true;
    }
  }
  return false;
}
