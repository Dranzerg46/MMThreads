/*  Multithreaded matrix multiplication
        C = A*B; where A, B, and C are square matrices of dimensions NxN.
    Compile with:  javac MMThreads.java
    Execution:    java MMThreads
    Name:
    Date:
    IT 386
*/

public class MMThreads {

    // Returns random square matrix with values between 0 and 1.
    private static double [][] generateMatrix(int N){
        double [][] m = new double[N][N];
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                m[i][j] = Math.random();
            }
        }
        return m;
    }

    // Computes sequential matrix multiplication 
    private static void mmSequential (double [][] A, double [][] B, double [][] C ){
        int N = A.length;
        for(int i = 0;i<N;i++){
	        for(int j=0;j<N;j++){
		        C[i][j] = 0;
		        for(int k=0;k<N;k++)
			        C[i][j] += A[i][k] * B[k][j];
		    }
        }
    }

    // Main method
    public static void main(String[] args) {

        int N = 500;
  
        double[][] C = new double[N][N]; // holds the result fro C = AxB;
        double[][] A = generateMatrix(N);
        double[][] B = generateMatrix(N);

        long startTime = System.currentTimeMillis(); // record time
        mmSequential(A,B,C);
	    long ElapsedTime = System.currentTimeMillis() - startTime; // record time
        System.out.println("Sequencial time: " + ElapsedTime+"ms");

        // Get physical cores/processors available.
        int numProc  = Runtime.getRuntime().availableProcessors();
        // Todo: Split the work among the threads, create threads and measure time. 
    }
}

// class that implements Runnable 
class mmParallel implements Runnable{
    double[][] A; 
    double[][] B;
    double[][] C;
    int low,high, N;
    mmParallel(double[][] A, double[][] B, double[][] C, int low, int high){
        this.A = A;  this.B = B;  this.C = C; this.low = low; this.high = high;
    }
    public void run(){
        //Todo: Implement threads' work
    }

}