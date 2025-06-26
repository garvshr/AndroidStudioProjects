fun main()
{
    val n1 = readln().toInt()
    val n2 = readln().toInt()
    println(divide(n1, n2))
}
fun divide(num1 : Int, num2: Int) : Double
{
    return (num1.toDouble()/num2.toDouble())
}