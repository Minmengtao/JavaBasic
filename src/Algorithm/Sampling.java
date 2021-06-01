package Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 模拟退火算法
 * @author: minmengtao
 * @date: 2021/5/30
 */
/*
 * J(y)：在状态y时的评价函数值
 * Y(i)：表示当前状态
 * Y(i+1)：表示新的状态
 * r： 用于控制降温的快慢
 * T： 系统的温度，系统初始应该要处于一个高温的状态
 * T_min ：温度的下限，若温度T达到T_min，则停止搜索
 */
class SimulatedAnnealing {
    public void algorithm() {
        int T = 1;
        while(true) {
            double delta = judge();
            if(delta < 0) {
                //满足的是最优解，更新
            }else{
                if(Math.exp(delta / T) > Math.random()) {
                    //满足的以一定概率更新最优解
                }
            }
        }

    }

    public double judge() {
        return 1L;
    }
}
public class Sampling {
    public static void main(String[] args) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
    }
}
