package 日常练习.数据结构练习.Set.treeSet练习;

public class Student implements Comparable<Student>{
    private String name;
    private int Chinese;
    private int Math;
    private int English;

    public Student() {
    }

    public Student(String name, int chinese, int math, int english) {
        this.name = name;
        Chinese = chinese;
        Math = math;
        English = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int math) {
        Math = math;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int english) {
        English = english;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Chinese=" + Chinese +
                ", Math=" + Math +
                ", English=" + English +
                '}' + "总分为" + getSum();
    }
    public int getSum(){
        return getChinese() + getEnglish() + getMath();
    }
    @Override
    public int compareTo(Student o) {
        //按照总分进行排序
        int result = this.getSum()-o.getSum();
        //总分一样，比较语文
        result = result == 0 ? this.getChinese()-o.getChinese():result;
        //语文一样，比较数学
        result = result == 0 ? this.getMath()-o.getMath():result;
        //数学一样，比较英语
        result = result == 0 ? this.getEnglish()-o.getEnglish():result;//可写可不写
        //如果都一样，按姓名排序
        result = result == 0 ? this.getName().compareTo(o.getName()):result;
        return result;
    }
}
