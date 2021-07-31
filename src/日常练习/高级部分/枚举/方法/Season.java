package 日常练习.高级部分.枚举.方法;

public enum Season {
    SPRING("春"){
        @Override
        public void show() {
            System.out.println(this.name);

        }
        //如果枚举类中有抽象方法
        //那么在枚举项中必须要全部重写

    },
    SUMMER("夏"){
        @Override
        public void show() {
            System.out.println(this.name);

        }
    },
    AUTUMN("秋"){
        @Override
        public void show() {
            System.out.println(this.name);

        }
    },
    WINTER("冬"){
        @Override
        public void show() {
            System.out.println(this.name);

        }
    };

    public String name;

    //空参构造
    private Season(){

    }

    private Season(String name) {
        this.name = name;
    }
    public abstract void show();
}
