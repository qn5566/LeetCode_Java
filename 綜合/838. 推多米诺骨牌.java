package 綜合;

class Solution {
    public String pushDominoes(String dominoes) {
        char[] dominoe = dominoes.toCharArray();
        int N = dominoe.length;
        int[] froces = new int[N];
        
        int froce = 0;
        for(int i = 0; i < N; i++){
            if(dominoe[i] == 'R'){
                froce = N ;
            }else if(dominoe[i] == 'L'){
                froce = 0 ;
            }else{
                froce = Math.max(froce - 1, 0);
            }
            
            froces[i] += froce;
        }
        
        froce = 0;
        for(int i = N-1; i >= 0; i--){
            if(dominoe[i] == 'L'){
                froce = N ;
            }else if(dominoe[i] == 'R'){
                froce = 0 ;
            }else{
                froce = Math.max(froce - 1, 0);
            }
            froces[i] -= froce;
        }
        
        
        StringBuilder res = new StringBuilder();
        for(int f : froces){
            if(f > 0){
                res.append('R');
            }else if(f < 0){
                res.append('L');
            }else{
                res.append('.');
            }
        }
        return res.toString();
    }
}