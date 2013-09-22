
 static final int N = 1111111; // 2*range
 static int[] v = new int[N]; //value we want to store for the intrval
 boolean[] push = new boolean[N];
/* init 
		push[1] = true;
        v[1] = 0;
	*/
/*	call
	modify(1, rangeStart/1, rangeEnd, intervalStart, intervalEnd, putThisVal);
    get(1, 1, rangeEnd, psition); //returns 0 for uncovered region

*/
    void modify(int x, int l, int r, int ll, int rr, int p) {
        if (l >= ll && r <= rr) {
            v[x] = p;
            push[x] = true;
            return;
        }
        if (push[x]) {
            v[x + x] = v[x + x + 1] = v[x];
            push[x + x] = push[x + x + 1] = true;
            push[x] = false;
        }
        int y = (l + r) >> 1;
        if (ll <= y) {
            modify(x + x, l, y, ll, rr, p);
        }
        if (rr > y) {
            modify(x + x + 1, y + 1, r, ll, rr, p);
        }
    }

    int get(int x, int l, int r, int p) {
        if (l == r) {
            return v[x];
        }
        if (push[x]) {
            v[x + x] = v[x + x + 1] = v[x];
            push[x + x] = push[x + x + 1] = true;
            push[x] = false;
        }
        int y = (l + r) >> 1;
        if (p <= y) {
            return get(x + x, l, y, p);
        }
        return get(x + x + 1, y + 1, r, p);
    }