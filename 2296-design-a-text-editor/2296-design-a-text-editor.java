class TextEditor {
    
    StringBuilder text;
    int cursor;
    public TextEditor() {
        text = new StringBuilder();
        cursor = 0;
    }
    
    public void addText(String t) {
        text.insert(cursor, t);
        cursor += t.length();
    }
    
    public int deleteText(int k) {
        if(k>cursor){
            text.delete(0, cursor);
            int res = cursor;
            cursor = 0;
            return res;
        }
        text.delete(cursor-k, cursor);
        cursor -= k;
        return k;
    }
    
    public String cursorLeft(int k) {
        if(k>cursor){
            cursor = 0;
            return "";
        }
        cursor -= k;
        return text.substring((cursor>10? cursor-10 : 0), cursor);
    }
    
    public String cursorRight(int k) {
        if(cursor+k>text.length()){
            cursor = text.length();
            return text.substring((cursor>10? cursor-10 : 0), cursor);
        }
        cursor += k;
        return text.substring((cursor>10? cursor-10 : 0), cursor);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */