public String doubleChar(String str) {
  String out = "";
  for (int i = 1; i <= str.length(); i++) {
    out += (str.substring(i-1, i)+(str.substring(i-1, i)));
  }
  return out;
}
