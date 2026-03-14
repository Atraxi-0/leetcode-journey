class Solution {

    void parenthesis(List<String> list, StringBuilder sb, int i, int j ) {
        if (i==0 && j==0) {
            list.add(sb.toString());
            sb = null;
            return;
        }
        if(i==j) parenthesis(list, sb.append('('), i-1, j);
        else if (i==0) parenthesis(list, sb.append(')'), i, j-1);
        else{
            parenthesis(list, sb.append('('), i-1, j);
            sb.deleteCharAt(sb.length() - 1);
            parenthesis(list, sb.append(')'), i, j-1);
        }
        sb.deleteCharAt(sb.length() - 1);
        return;
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        parenthesis(list, sb, n, n);
        return list;
    }
}