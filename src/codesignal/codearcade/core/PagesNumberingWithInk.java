package codesignal.codearcade.core;

public class PagesNumberingWithInk {
    public static void main(String[] args) {
        PagesNumberingWithInk s = new PagesNumberingWithInk();
        System.out.println(s.solution(1, 5));
    }

    int solution(int current, int numberOfDigits) {
        int i = current;
        while (numberOfDigits > 0) {
            int digiCount = getDigiCount(i);
            System.out.println("digiCount:"+digiCount);
            if (digiCount == numberOfDigits)
                return i;
            else if (digiCount > numberOfDigits)
                return i - 1;
            numberOfDigits = numberOfDigits - digiCount;
            i++;
        }

        return i - 1;
    }

    int getDigiCount(int num) {
        int count = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }

        return count;
    }

    int solution2(int current, int numberOfDigits) {
        int n = 0;
        while (numberOfDigits > 0) {
            if (current >= 1000) {
                n = (int) Math.floor(numberOfDigits / 4);
                numberOfDigits = 0;
                current += n;
            } else if (current >= 100) {
                n = (int) Math.min(1000 - current, Math.floor(numberOfDigits / 3));
                current += n;
                numberOfDigits -= n * 3;
                if (numberOfDigits < 4) numberOfDigits = 0;
            } else if (current >= 10) {
                n = (int) Math.min(100 - current, Math.floor(numberOfDigits / 2));
                current += n;
                numberOfDigits -= n * 2;
                if (numberOfDigits < 3) numberOfDigits = 0;
            } else {
                n = Math.min(10 - current, numberOfDigits);
                current += n;
                numberOfDigits -= n;
            }
        }
        return current - 1;
    }
}
