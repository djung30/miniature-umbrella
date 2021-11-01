public boolean endOther(String a, String b) {
  String an;
  String bn;
  an = a.toLowerCase();
  bn = b.toLowerCase();
  if (an.equals(bn)) {
    return true;
  }
  if (an.length()  > bn.length()) {
    for (int i = 0; i < an.length()-bn.length(); i++) {
    if (bn.equals(an.substring(an.length()-bn.length()))) {
      return true; 
    }
    }
  }
  if (an.length()  < bn.length()) {
    for (int i = 0; i < bn.length()-an.length(); i++) {
    if ((an.equals(bn.substring(bn.length()-an.length())))) {
      return true; 
    }
    }
  }
  return false;
}
