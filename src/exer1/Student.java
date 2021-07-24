package exer1;

/**
 * @ProjectName: JavaSenior
 * @Package: exer1
 * @ClassName: Student
 * @Author: 007
 * @Date: 2021/6/16 11:10
 * @Version: 1.8
 */
public class Student implements Comparable {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
            return Integer.compare(this.score,((Student) o).score);
        }
        throw new RuntimeException("輸入類型不匹配");
    }
}
