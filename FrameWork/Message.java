package FrameWork;

    public class Message
    {
        //kiểu message
        public MessageType type = MessageType.Success;
        

        public String label;
        //nội dung in
        public String text = "Your action has completed succesfully";
        //hàm thực hiện khi đã đồng ý 
        public String backRoute;
        public Message(){}
        public Message(MessageType type, String text, String label, String backRoute){
            this.type = type;
            this.label = label;
            this.backRoute = backRoute;
            this.text = text;
        }
        public Message(MessageType type, String text, String label){
            this.type = type;
            this.label = label;
            this.text = text;
        }
        public String getBackRoute() {
            return backRoute;
        }
        public void setBackRoute(String backRoute) {
            this.backRoute = backRoute;
        }
        public String getLabel() {
            return label;
        }
        public void setLabel(String label) {
            this.label = label;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public MessageType getType() {
            return type;
        }
        public void setType(MessageType type) {
            this.type = type;
        }

    public static enum MessageType { Success, Information,  Error, Confirmation}

    }




