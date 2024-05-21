/**
 * 
 */
package unittests;

import static org.junit.jupiter.api.Assertions.*;

import primitives.Point;
import primitives.Vector;
import primitives.Double3;


import org.junit.jupiter.api.Test;

/**
 * 
 */
class VectorTests {
	
	   @Test
	    void testVectorConstructorWithDouble3() {
			// ============Equivalence Partitions Tests ==============

	        // Test case setup
	        Double3 double3 = new Double3(1.0, 2.0, 3.0);

	        // Create the vector
	        Vector vector = new Vector(double3);

	        // Verify that the vector was created correctly
	        assertEquals(double3, vector,"wrong constructor vector");
	        // =============== Boundary Values Tests ==================
			 // TC11: test zero vector from constructor 
			 assertThrows(IllegalArgumentException.class, () -> vector.equals(Double3.ZERO), //
			 "crossProduct() for parallel vectors does not throw an exception");
	    }

	    @Test
	    void testVectorConstructorWithComponents() {
			// ============Equivalence Partitions Tests ==============

	        // Test case setup
	        double x = 1.0;
	        double y = 2.0;
	        double z = 3.0;

	        // Create the vector
	        Vector vector = new Vector(x, y, z);

	        // Verify that the vector was created correctly
	        assertEquals(new Double3(x, y, z), vector,"wrong constructor vector");
	     // =============== Boundary Values Tests ==================
			 // TC11: test zero vector from constructor 
			 assertThrows(IllegalArgumentException.class, () -> vector.equals(Double3.ZERO), //
			 "crossProduct() for parallel vectors does not throw an exception");
	    }

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}.
	 */
	@Test
	void testAddVector() {
		// ============Equivalence Partitions Tests ==============
		Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(2, 4, 6);
        Vector v3 = new Vector(-1,-2,-3);
        
        Vector expected1 = new Vector(0,0,0);
        Vector expected = new Vector(3, 6, 9);
		 // TC01: Test that add vector to vector and check that the result is proper.

        assertEquals(expected, v1.add(v2),"wrong add vector");
        assertEquals(expected, v3.add(v2),"wrong add vector");

     // =============== Boundary Values Tests ==================
		 // TC11: test zero result from add  opposite and equals vectors 
		 assertThrows(IllegalArgumentException.class, () ->v1.add(v3).equals(expected1), //
		 "crossProduct() for parallel vectors does not throw an exception");
	
	
	}

	/**
	 * Test method for {@link primitives.Vector#scale(int)}.
	 */
	@Test
	void testScale() {
		// ============Equivalence Partitions Tests ==============
				Vector v = new Vector(1, 2, 3);
		        int scalar = 2;
		        Vector expected = new Vector(2, 4, 6);
				 // TC01: Test that multiply a vector by a scalar and check that the result is correct.
		        assertEquals(expected, v.scale(scalar), "wrong scaled vector");
			}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	void testDotProduct() {
		// ============Equivalence Partitions Tests ==============
		Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(2, 4, 6);
        double expected = 28;
        //TC01: Checks the correctness and result of the inner multiplication operation (dot product) between two vectors
        assertEquals(expected, v1.dotProduct(v2), "wrong dot product value");
	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	void testCrossProduct() {
		 Vector v1         = new Vector(1, 2, 3);
	     Vector v2         = new Vector(-2, -4, -6);
	     Vector v3         = new Vector(0, 3, -2);
		
		 // ============ Equivalence Partitions Tests ==============
		 Vector vr = v1.crossProduct(v3);
		 // TC01: Test that length of cross-product is proper (orthogonal vectors taken
		 // for simplicity)
		 assertEquals(v1.length() * v3.length(), vr.length(), "crossProduct() wrong result length");
		 // TC02: Test cross-product result orthogonality to its operands
		 assertEquals(0, vr.dotProduct(v1), "crossProduct() result is not orthogonal to 1st operand");
		 assertEquals(0, vr.dotProduct(v3), "crossProduct() result is not orthogonal to 2nd operand");
		 // =============== Boundary Values Tests ==================
		 // TC11: test zero vector from cross-product of parallel vectors
		 assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(v2), //
		 "crossProduct() for parallel vectors does not throw an exception");
		 }

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	void testLengthSquared() {
		// ============ Partitions Tests ==============
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	void testLength() {
		// ============Equivalence Partitions Tests ==============
		Vector v = new Vector(1, 2, 3);
        double expected = Math.sqrt(14);
      //TC01: Checks the correctness and the result step length vector.
        assertEquals(expected, v.length(), "wrong length value");
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	void testNormalize() {
		Vector v=new Vector(0,3,4);
		Vector n=v.normalize();
		// ============Equivalence Partitions Tests ==============
	//TC01: Simple test
		assertEquals(1d,n.lengthSquared(),0.00001,"wrong normalized vector length");
		assertThrows(IllegalArgumentException.class,()->v.crossProduct(n),"normalized vector is not in the same direction");
		assertEquals(new Vector (0,0.,0.8),n,"wrong normalized vector");
	
	}

}
