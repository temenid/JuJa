package com.juja.woland;

import java.util.Arrays;

/**
 * Created by woland on 22.11.15.
 */
public class Merger {
    public static int[] merge(int[] fst, int[] snd) {
        int[] result = new int[fst.length + snd.length];
        int fstIndex = 0;
        int sndIndex = 0;

        while (fstIndex < fst.length && sndIndex < snd.length) {
            if (fst[fstIndex] < snd[sndIndex]) {
                result[fstIndex + sndIndex] = fst[fstIndex++];
            } else {
                result[fstIndex + sndIndex] = snd[sndIndex++];
            }
        }

        while (fstIndex  < fst.length) {
            result[fstIndex + sndIndex] = fst[fstIndex++];
        }
        while (sndIndex  < snd.length) {
            result[fstIndex + sndIndex] = snd[sndIndex++];
        }

        System.out.println("fstIndex: " + fstIndex + "; sndIndex: " + sndIndex);

        return result;
    }

    public static void main(String[] args) {
        int [] fst = {};
        int [] snd = {2};

        int [] result = merge(fst, snd);
        System.out.println(Arrays.toString(result));

    }
}
