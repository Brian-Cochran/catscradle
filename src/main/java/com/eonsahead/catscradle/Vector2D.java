
package com.eonsahead.catscradle;

/**
 * This class models a vector in two dimensions.
 * 
 * 
 * <p>
 * Like a length (feet and inches), weight (pounds
 * and ounces), time (hours and minutes), fraction
 * (numerator and denominator), a complex number
 * (real and imaginary parts), a 2D vector is a thing
 * with two parts that can be added.
 * </p>
 * 
 * <img src="../../../src/vector2d/Vector2D.png" alt="UML class diagram">
 * 
 * @author CSC140 Foundations of Computer Science
 * @version 6 March 2013
 */
public class Vector2D {
  
    private double x;
    private double y;

    /**
     * A vector can represent a point.
     * 
     * @param x is the x coordinate of the point.
     * @param y is the y coordinate of the point.
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    } // Vector2D( double, double )

    /**
     * The addition of one vector to another
     * produces a third vector.
     * 
     * <p>
     * The components of the sum are the sums of
     * the corresponding components of the vectors we add.
     * </p>
     * 
     *   u  = (u_x, u_y ) \\
     *   v  = (v_x, v_y ) \\
     *   u + v = (u_x + v_x, u_y + v_y)
     * 
     * @param v is the vector to be added to this one.
     * @return the sum of this vector and the other vector.
     */
    public Vector2D add( Vector2D v ) {
        double xCoord = this.getX() + v.getX();
        double yCoord = this.getY() + v.getY();
        return new Vector2D(xCoord, yCoord);
    } // add (Vector2D )
    
    /**
     * Multiplication of the components of a vector
     * stretches the vector.
     * 
     * Scaling u} = (u_x, u_y) by (xFactor, yFactor)
     * produces a new vector: (xFactor * u_x, yFactor * u_y).
     * 
     * @param xFactor is the amount of horizontal stretching.
     * @param yFactor is the amount of vertical stretching.
     * @return 
     */
    public Vector2D scale( double xFactor, double yFactor ) {
        double xCoord = this.getX() * xFactor;
        double yCoord = this.getY() * yFactor;
        return new Vector2D( xCoord , yCoord );
    } // scale( double )
    
    /**
     * We will often want to stretch a vector the
     * same amount in the horizontal and vertical directions.
     * 
     * Scaling u = (u_x, u_y) by factor
     * produces a new vector: (factor * u_x, factor * u_y).
     * 
     * <p>
     * If we think of a vector as an arrow, this
     * operation produces a new vector that has the
     * same (or opposite when the scale factor is negative) 
     * direction as the original but a different length.
     * </p>
     * 
     * @param factor is the amount of stretching.
     * @return a stretched (or contracted) vector.
     */
    public Vector2D scale( double factor ) {
        double xCoord = this.getX() * factor;
        double yCoord = this.getY() * factor;
        return new Vector2D( xCoord, yCoord );
    } // scale( double )
    
    /**
     * If we think of a vector as an arrow rooted at the
     * origin, then we can imagine rotating it like the
     * hand on a clock.
     * 
     * Rotating a vector whose components are (u_x, u_y)
     * by psi radians produces a new vector whose
     * components (x, y) are as follows:
     * 
     *   x  = u_x * cos( psi ) - u_y * sin( psi ) 
     *   y  = u_x * sin( psi ) - u_y * cos( psi )
     * 
     * @param angle is the amount of rotation.
     * @return is a rotated version of this vector.
     */
    public Vector2D rotate( double angle ) {
        double xCoord = (this.getX() * Math.cos(angle)) - (this.getY() * Math.sin(angle));
        double yCoord = (this.getX() * Math.cos(angle)) - (this.getY() * Math.cos(angle));
        return new Vector2D( xCoord, yCoord );
    } // rotate( double )
    
    /**
     * We will often want to rotate, scale, and translate (move)
     * a vector in that order.
     * 
     * @param angle is the amount of rotation.
     * @param scaleX is the amount of horizontal stretching.
     * @param scaleY is the amount of vertical stretching.
     * @param deltaX is the distance moved in the horizontal direction.
     * @param deltaY is the distance moved in the vertical direction.
     * @return is a rotated, scaled, and translated version of this vector.
     */
    public Vector2D rotateScaleTranslate( double angle, double scaleX, double scaleY, double deltaX, double deltaY ) {
        Vector2D newVector = this.rotate(angle);
        newVector = newVector.scale(scaleX, scaleY);
        Vector2D addVector = new Vector2D(deltaX, deltaY);
        newVector = newVector.add(addVector);
        return newVector;
    } // rotateScaleTranslate( double, double, double, double, double )
    
    /**
     * The dot product of this vector with another vector gives
     * us a number.
     * 
     *   u  = (u_x, u_y) 
     *   v  = (v_x, v_y) 
     *   u * v  = u_x v_x + u_y v_y
     * 
     * <p>
     * This number is the length of the one vector's projection
     * on the other (the length of its shadow).
     * </p>
     * 
     * @param v is the other vector in the dot product with this vector. 
     * @return is the sum of the products of the vector's corresponding 
     * components.
     */
    public double dot( Vector2D v ) {
        double xProduct = this.getX() * v.getX();
        double yProduct = this.getY() * v.getY();
        return xProduct + yProduct;
    } // dot( Vector2D )
    
    /**
     * The magnitude of a vector is its length.
     * 
     *   u  = (u_x, u_y)
     *   | u | = sqrt( u_x^2 + u_y^2 )
     *         = sqrt{ u.dot(u) }
     * 
     * <p>
     * The magnitude is also the square root of
     * the dot product of the vector with itself.
     * This is just rule we use to find the length
     * of the hypotenuse of a triangle.
     * </p>
     * 
     * @return the length of the vector.
     */
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } // magnitude()
    
    /**
     * Here's an accessor method to allow a
     * read-only view of the vector's x component
     * from methods in other classes.
     * 
     * @return the value of the vector's x component. 
     */
    public double getX() {
        return this.x;
    } // getX()
    
     /**
     * Here's an accessor method to allow a
     * read-only view of the vector's y component
     * from methods in other classes.
     * 
     * @return the value of the vector's y component. 
     */
    public double getY() {
        return this.y;
    } // getY()
    
    /**
     * Here's a way to produce a printable representation
     * of the vector.
     * 
     * @return the components of the vector in parentheses
     * and separated by a comma.
     */
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    } // toString()
    
    /**
     * More than one class in a program can have
     * a <code>main()</code> method.
     * 
     * <p>
     * <code>main()</code> methods are a convenient
     * place to put code that tests the constructors
     * and methods of a class.
     * </p>
     * 
     * @param args is an array that we do not use
     * but must include in every <code>main()</code> method.
     */
    public static void main(String[] args) {
        Vector2D a = new Vector2D( 3, 4 );
        Vector2D b = new Vector2D( 5, 12 );
        
        System.out.println( "magnitude of a " + a.magnitude() );
        
    } // main( String [] )
} // Vector2D

