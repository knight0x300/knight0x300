  int lessThanOrEqualCount(int[] A, int key) {
        int low = -1, up = A.length;
        while (up - low > 1) {
            int mid = ((up + low) / 2);
            if (A[mid] <= key) {
              
                low = mid;
            } else {
                up = mid;
            }


        }
        return low + 1;

    }
    int lessThanCount(int[] A, int key) {
        int low = -1, up = A.length;
        while (up - low > 1) {
            int mid = ((up + low) / 2);
            if (A[mid] < key) {
              
                low = mid;
            } else {
                up = mid;
            }


        }
        return low + 1;

    }