# 정렬

### 선택 정렬

```java
public static void main(String[] args) {
   int[] arr = {33, 5, 98, 75, 87, 12, 4, 61, 100};
   selectionSort(arr);
        
   System.out.println(Arrays.toString(arr));
   // 출력 : [4, 5, 12, 33, 61, 75, 87, 98, 100]
}

public static void selectionSort(int[] list) {
	 int idxMin, tmp;
    
   for (int i = 0; i < list.length - 1; i++) {
       idxMin = i;
       for (int j = i + 1; j < list.length; j++) {
           if (list[j] < list[idxMin]) {
               idxMin = j;
           }
       }
       tmp = list[idxMin];
       list[idxMin] = list[i];
       list[i] = tmp;
	}
}
```

<br>

### 삽입 정렬

```java
public static void main(String[] args) {
   int[] arr = {33, 5, 98, 75, 87, 12, 4, 61, 100};
   insertionSort(arr);

	 System.out.println(Arrays.toString(arr));
	 // 출력 : [4, 5, 12, 33, 61, 75, 87, 98, 100]
}

public static void insertionSort(int[] arr){
     for(int idx = 1; idx < arr.length; idx++) {
         int tmp = arr[idx];
         int aux = idx - 1;

         while(aux >= 0 && arr[aux] > tmp) {
              arr[aux + 1] = arr[aux];
              aux--;
         }

         arr[aux + 1] = tmp;
      }
}
```

<br>

#### 합병 정렬

```java
public static void main(String[] args) {
     int[] arr = {33, 5, 98, 75, 87, 12, 4, 61, 100};
     mergeSort(arr, 0, arr.length - 1);
        
     System.out.println(Arrays.toString(arr));
     // 출력 : [4, 5, 12, 33, 61, 75, 87, 98, 100]
}

public static void mergeSort(int[] arr, int left, int right) {
     if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
     }
}

public static void merge(int[] arr, int left, int mid, int right) {
     int i = left, j = mid + 1, k = left;
     int[] tmp = new int[arr.length];

     while (i <= mid && j <= right) {
         if (arr[i] <= arr[j]) {
             tmp[k++] = arr[i++];
         }
         else {
             tmp[k++] = arr[j++];
         }
     }
        
     while (i <= mid) {
	        tmp[k++] = arr[i++];
     }

     while (j <= right) {
	        tmp[k++] = arr[j++];
     }

     for (int idx = left; idx <= right; idx++) {
          arr[idx] = tmp[idx];
     }
}
```

<br>

### 퀵 정렬

```java
public static void main(String[] args) {
     int[] arr = {33, 5, 98, 75, 87, 12, 4, 61, 100};
     quickSort(arr, 0, arr.length - 1);
        
     System.out.println(Arrays.toString(arr));
     // 출력 : [4, 5, 12, 33, 61, 75, 87, 98, 100]
}

public static void quickSort(int[] arr, int p, int r) {
	   if(p < r) {
        int q = partition(arr, p, r);
        quickSort(arr, p, q - 1);
        quickSort(arr, q + 1, r);
     }
}

public static int partition(int[] arr, int p, int r) {
     int i = p, j = r;
     int pivot = arr[p];

     while(i < j) {
         while(pivot < arr[j]) {
             j--;
         }

         while(i < j && pivot >= arr[i]){
             i++;
         }

         int tmp = arr[i];
         arr[i] = arr[j];
         arr[j] = tmp;
	  }
    arr[p] = arr[i];
    arr[i] = pivot;

    return i;
}
```

