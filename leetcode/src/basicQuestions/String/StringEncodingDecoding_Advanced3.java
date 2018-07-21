package unitTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
*   a0a1a2
*   a3a4a5
*  
*  Assumption:
*  duplicate less than 10, we could consider two digits every time.
*  
 * explanation:
 * https://docs.google.com/document/d/1Ic2DZ6fVZcbz9Y-OcEhc9-UUflLOvMcn5p4TOcGZO7Y/edit 

	in-place algorithm is an algorithm which transforms input using no auxiliary data structure. 
	However a small amount of extra storage space is allowed for auxiliary variables. 
	The input is usually overwritten by the output as the algorithm executes. 
	In-place algorithm updates input sequence only through replacement or swapping of elements. 
	An algorithm which is not in-place is sometimes called not-in-place or out-of-place
	
 * @author xx65
 *
 */
public class StringEncodingDecoding_Advanced3 {

	@Test
	public void test_decompressingString() {
		/* 
		 in place method
		 when we say in place, it usually means the input is a long enough char array
	     and the original string only occupies part of the array starting from index 0
	     and usually the length to represent the original string is given
	     */
		Assert.assertEquals("aaabbccc", decompressingInPlace("d0a3b2c3e0".toCharArray()));
		// String Builder
		Assert.assertEquals("aaabbccc", decompressingStringBuilder("a3b2c3".toCharArray()));
	}
	
	/*
	   We will scan the String in 2 rounds.
	   The first round is from left-hand side to right-hand side to handle the shorter decode, ex. a0b1c2
	   the second round is from right-hand side to left-hand side to handle the longer decoding, ex. a3b4d5
	*/
	private String decompressingInPlace(char[] input) {
		return longDecodeing(input, shortDecoding(input));
	}
	
	/*
		handle aac3d4e5 
		scan the array from right-hand side to left-hand side
	*/
	private String longDecodeing(char[] input, int length) { //[a, 3, b, b, c, 3, c, 3, e, 0], 6
		int newLength = length; // we only consider the length between 0 - (length - 1)
		// recaculate the new length
		for(int i = 0; i < length; i++) {
			int count = getDigit(input[i]); // (a-z) - '0' and  (1 - 9) - '0'
			// assumption, the max number of duplicate character is less than 9. 
			// 1. skip character from a - z
			// 2. assumption: the max number is 9
			if(count > 2 && count <= 9) { 
				newLength += count - 2;
			}
		}
		
		char[] result = new char[newLength];
		newLength = newLength - 1;
		length--;
		while (length > 0) { // we only consider the length between 0 - (length - 1)
			int count = getDigit(input[length]);
			if(count > 2 && count <= 9) {
				while(count > 0) {
					result[newLength--] = input[length-1];
					count--;
				}
				length -= 2; // skip character. 
			} else {
				result[newLength--] = input[length--];
			}
		}
		return new String(result);
	}

	/*
	handle a3b2c3d0 
	scan the array from left-hand side to right-hand side
	*/
	private int shortDecoding(char[] input) {
		int slow = 0, fast = 1;
		while(fast < input.length ) {
			int count = getDigit(input[fast]);
			if(count >= 0 && count <= 2) {
				while(count > 0) {
					input[slow++] = input[fast - 1];
					count--;
				}
			} else {
				input[slow++] = input[fast - 1]; // d4 -> d4
				input[slow++] = input[fast];	// d4 -> d4
			}
			fast += 2;
		}
		return slow;
	}

	private String decompressingStringBuilder(char[] input) {
		if (input == null || input.length <= 1 || input.length % 2 != 0) {
			return new String(input);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < input.length; i++) {
			char tmp = input[i++];
			int count = getDigits(input[i]);
			while(count > 0) {
				sb.append(tmp);
				count--;
			}
		}
		return sb.toString();
	}
	
	private int getDigits(char tmp) {
		return tmp - '0';
	}

	// method 1, use StringBuilder
    public String decompress(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i++];
            int count = array[i] - '0';
            for (int c = 0; c < count; c++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // method 2, in place
    // when we say in place, it usually means the input is a long enough char array
    // and the original string only occupies part of the array starting from index 0
    // and usually the length to represent the original string is given
    public String decompress2(String input) {
        if (input.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        // we need to handle the a0, a1, a2 case (the decoded string is shorter)
        // and a3, a4 ... case (the decoded string is longer)
        // in 2 pass to avoid conflict, since the encoding of the 2 cases require different directions
        return decodeLong(array, decodeShort(array));
    }

    // return the length of he decoded string,
    // only cares about a0, a1, a2,
    // the decoded string is shorter
    private int decodeShort(char[] input) {
        // since the decoded string is shorter, we should do the decoding work from left to right
        int end = 0;
        for (int i = 0; i < input.length; i += 2) {
            int digit = getDigit(input[i + 1]);
            if (digit >= 0 && digit <= 2) {
                for (int j = 0; j < digit; j++) {
                    input[end++] = input[i]; // orig array a1-> a, a2-> aa
                }
            } else {
                // we don't handle the longer decoded string here
                input[end++] = input[i]; // a3-> a3
                input[end++] = input[i + 1]; // a3-> a3
            }
        }
        return end; // end -> input.length
    }

    private int getDigit(char digit) {
        return digit - '0';
    }

    // take care of a3, a4, a5...
    // the decoded string is longer
    // length: the length of the valid partition starting from index 0
    private String decodeLong(char[] input, int length) {
        // we need to calculate the new required length
        int newLength = length;
        for (int i = 0; i < length; i++) {
            int digit = getDigit((input[i]));
            if (digit > 2 && digit <= 9) {
                newLength += digit - 2;
            }
        }
        // Notice: if it is required to do this in place,
        // usually the input array is a sufficient large one
        // you will not need to allocate a new array
        char[] result = new char[newLength];
        int end = newLength - 1;
        for (int i = length - 1; i >= 0; i--) { // calculate from old end to 0
            int digit = getDigit(input[i]);
            if (digit > 2 && digit <= 9) {
                i--;
                for (int j = 0; j < digit; j++) {
                    result[end--] = input[i];
                }
            } else {
                // we already take care the shorter cases, a1 in previous pass
                // we can leave as it is e.g. the input could be abc2
                result[end--] = input[i];
            }
        }
        return new String(result);
    }

    @Test
    public void test_decompressString() {
//        Assert.assertEquals("abbcccc", decompress("a1c0b2c4e0"));
        Assert.assertEquals("abbcccc", decompress2("a1c0b2c4e0"));
//        Assert.assertEquals("aaabbcccc", decompress2("a3b2c4"));
    }
}