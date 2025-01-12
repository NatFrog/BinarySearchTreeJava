package assign08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * 
 */
public class BinarySearchTreeTester {
	private BinarySearchTree<String> twoWords;
	
	@BeforeEach
	public void setup() {
		twoWords = new BinarySearchTree<String>();
		twoWords.add("hello");
		twoWords.add("world");
	}

//	 test add() ------------------------------------------------------------------------------------

	@Test
	public void testAdd() {
		assertTrue(twoWords.contains("world"));
	}
	
	@Test
	public void testAddSize() {
		assertEquals(2, twoWords.size());
	}
	
	
	@Test
	public void testIsEmpty() {
		BinarySearchTree<String> words = new BinarySearchTree<String>();
		words.add("ab");
		words.add("ac");
		words.add("ad");
		assertFalse(words.isEmpty());
		words.remove("ac");
		words.remove("ab");
		words.remove("ad");
		assertTrue(words.isEmpty());
		words.add("ad");
		assertFalse(words.isEmpty());
		words.remove("ad");
		assertTrue(words.isEmpty());
	}
	
	@Test
	public void testAddALot() {
		BinarySearchTree<String> words = new BinarySearchTree<String>();
		words.add("ab");
		words.add("ac");
		words.add("ad");
		words.add("ae");
		words.add("af");
		words.add("ag");
		words.add("ah");
		words.add("ai");
		words.add("aj");
		words.remove("aj");
		assertTrue(words.contains("ai"));
		assertTrue(words.contains("ag"));
		assertTrue(words.contains("af"));
		assertFalse(words.contains("jij"));
		assertFalse(words.contains("aj"));
	}
	
	@Test
	public void testLast() {
		BinarySearchTree<String> words = new BinarySearchTree<String>();
		words.add("ab");
		words.add("ac");
		words.add("ad");
		words.add("ae");
		words.add("af");
		words.add("ag");
		words.add("ah");
		words.add("ai");
		words.add("aj");
		assertEquals("aj", words.last());
	}
	
	@Test
	public void testRemove2ChildrenString() {
		BinarySearchTree<String> w = new BinarySearchTree<String>();
		w.add("hello");
		w.add("world");
		w.add("apple");
		w.remove("hello");
		assertTrue(w.contains("world"));
		assertEquals(2, w.size());
		assertTrue(w.contains("apple"));
		assertFalse(w.contains("hello"));
		assertTrue(w.contains("world"));
	}
	
	@Test
	public void testRemoveChildren2Integer() {
		BinarySearchTree<Integer> words = new BinarySearchTree<Integer>();
		words.add(5);
		words.add(8);
		words.add(3);
		words.add(7);
		words.add(1);
		assertEquals(5, words.size());
		words.remove(5);
		assertEquals(4, words.size());
		assertFalse(words.contains(5));
	}
	
	@Test
	public void testToArrayList() {
		BinarySearchTree<Integer> words = new BinarySearchTree<Integer>();
		words.add(5);
		words.add(8);
		words.add(3);
		words.add(7);
		words.add(1);
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(8);
		assertEquals(list, words.toArrayList());
	}
	
	@Test
	public void testRemove2Children() {
		twoWords.add("apple");
		twoWords.remove("hello");
		assertEquals(2, twoWords.size());
		twoWords.remove("world");
		assertEquals(1, twoWords.size());
		assertTrue(twoWords.contains("apple"));
//		
	}
	
	@Test 
	public void testBST() {
		BinarySearchTree<String> empty = new BinarySearchTree<String>();
		assertEquals(0, empty.size());
	}
	
//	test add() ----------------------------------------------------------
	
	@Test
	public void testAdd2() {
		BinarySearchTree<String> empty = new BinarySearchTree<String>();
		empty.add("hi");
		assertEquals(1, empty.size());
	}
	
	@Test
	public void testAdd23() {
		twoWords = new BinarySearchTree<String>();
		twoWords.add("hello");
		twoWords.add("world");
		assertEquals(2, twoWords.size());
		twoWords.add("hi");
		assertEquals(3, twoWords.size());
		twoWords.add("h");
		assertEquals(4, twoWords.size());
		twoWords.add("i");
		assertEquals(5, twoWords.size());
		twoWords.add("hii");
		assertEquals(6, twoWords.size());
		assertEquals(true, twoWords.contains("i"));
		
	}
//	test isEmpty() ----------------------------------------------------------
	
	@Test
	public void testEmpty() {
		twoWords = new BinarySearchTree<String>();
		twoWords.add("hello");
		twoWords.add("world");
		assertEquals(false, twoWords.isEmpty());
		twoWords.remove("world");
		twoWords.remove("hello");
		assertEquals(true, twoWords.isEmpty());
	}
	
//	test contains() ----------------------------------------------------------
	
	@Test
	public void testcontains() {
		BinarySearchTree<Integer> empty = new BinarySearchTree<Integer>();
		empty.add(0);
		empty.add(1);
		empty.add(2);
		empty.add(3);
		empty.add(4);
		empty.add(5);
		empty.add(6);
		empty.add(7);
		empty.add(8);
		empty.add(9);
		assertEquals(true, empty.contains(0));
	}
	
//	test containsAll() ----------------------------------------------------------
	
	@Test
	public void testcontainsAll() {
		BinarySearchTree<Integer> empty = new BinarySearchTree<Integer>();
		empty.add(0);
		empty.add(1);
		empty.add(2);
		empty.add(3);
		empty.add(4);
		empty.add(5);
		empty.add(6);
		empty.add(7);
		empty.add(8);
		empty.add(9);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(0);
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(5);
		expected.add(6);
		expected.add(7);
		expected.add(8);
		expected.add(9);
		assertEquals(true, empty.containsAll(expected));
	}
	
//	test remove() ----------------------------------------------------------
	
	@Test
	public void testRemoveAll() {
		BinarySearchTree<Integer> empty = new BinarySearchTree<Integer>();
		empty.add(0);
		empty.add(1);
		empty.add(2);
		empty.add(3);
		empty.add(4);
		empty.add(5);
		empty.add(6);
		empty.add(7);
		empty.add(8);
		empty.add(9);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(7);
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(5);
		expected.add(6);
		expected.add(0);
		expected.add(8);
		expected.add(9);
		assertEquals(true, empty.removeAll(expected));
	}
	
//	test spellCheck() ----------------------------------------------------------
	
//	@Test
//	public void testSpellCheck() {
//		SpellChecker spellItOut = new SpellChecker(new File("src/assign08/dictionary.txt"));
//		List<String> expected = new ArrayList<String>();
//		expected.add("thiff");
//		expected.add("maroscimulation");
//		expected.add("yaaning");
//		for(int i = 0; i < expected.size(); i++) {
//			assertEquals(expected.get(i), spellItOut.spellCheck(new File("src/assign08/small_Dictionary.txt")).get(i));
//		}
//		assertEquals(expected.size(), spellItOut.spellCheck(new File("src/assign08/small_Dictionary.txt")).size());
//
//	}
}
