package issues;

public class Week5_5 extends Thread {

    static int a[] = new int[(int) (Math.random() * 10)+1];

    public static void main(String[] args) {
        int num;
        int temp;
        System.out.println("Total numbers:"+a.length);
        for (int i = 0; i < a.length; i++) {
            num =(int) (Math.random() * 1000001);
            a[i] = num;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
    }
        Mean.start();
        Mode.start();
        Median.start();
    }

    static Thread Mean = new Thread() {
        public void run() {
            double mean;
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += a[i];
            }
            mean = sum / (a.length);
            System.out.println("Mean: " + mean);
        }
    };

    static Thread Mode = new Thread() {
        public void run() {
            double mode;
            double maxValue = 0;
            double maxCount = 0;

            for (int i = 0; i < a.length; ++i) {
                int count = 0;
                for (int j = 0; j < a.length; ++j) {
                    if (a[j] == a[i]) {
                        ++count;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    maxValue = a[i];
                }
            }
            mode = maxValue;
            System.out.println("Mode: " + mode);
        }
    };

    static Thread Median = new Thread() {
        public void run() {
            double median;
            int middle = a.length / 2;
            if (a.length % 2 == 1) {
                median=a[middle];
            } else {
                median=(a[middle-1]+a[middle])/2.0;
            }
            System.out.println("Median: "+median);
        }
    };
}
