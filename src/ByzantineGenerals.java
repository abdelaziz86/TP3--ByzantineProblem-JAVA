import java.util.Arrays;

public class ByzantineGenerals {
	public static void main(String[] args) {
        int N = 3;  
        int k = 1; 

        int[] nodeValues = new int[N];

         
        for (int i = 0; i < N; i++) {
            if (i < N - 1) {
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        nodeValues[j] = (j < N - 1) ? i : (int) (Math.random() * N);
                    }
                }
            } else { 
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        nodeValues[j] = (int) (Math.random() * N);
                    }
                }
            }
        }

        System.out.println("Step 1: Node values after sending their values to others");
        System.out.println(Arrays.toString(nodeValues));
 
        int[] localVector = Arrays.copyOf(nodeValues, N);

        System.out.println("Step 2: Local vector after collecting received values");
        System.out.println(Arrays.toString(localVector));
 

        System.out.println("Step 3: Sending local vector to other nodes");
 
        int[] resultVector = new int[N];

        for (int i = 0; i < N; i++) {
            int[] receivedVector = Arrays.copyOf(nodeValues, N);

            if (i < N - 1) { 
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        receivedVector[j] = localVector[j];
                    }
                }
            } else { 
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        receivedVector[j] = (int) (Math.random() * N);
                    }
                }
            }
 
            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int value : receivedVector) {
                    if (value == j) {
                        count++;
                    }
                }
                resultVector[j] = (count > (N - k) / 2) ? j : -1; 
            }
        }

        System.out.println("Step 4: Result vector with majority values");
        System.out.println(Arrays.toString(resultVector));
    }
}
