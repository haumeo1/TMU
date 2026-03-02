defmodule MidtermTest do
  use ExUnit.Case
  doctest Midterm

  test "mc1. ", do: assert Midterm.mc1() in [1, 2, 3, 4, 5]

  test "1a. ", do: assert Midterm.q1({:ok, "HI"}) == {:ok, "HI"}
  test "1b. ", do: assert Midterm.q1({0, 0}) == {0, 0} 
  test "1c. ", do: assert Midterm.q1({3, 0}) == {1, 0}
  test "1d. ", do: assert Midterm.q1({0, 99}) == {0, 1}
  test "1e. ", do: assert Midterm.q1({5, 6}) == {5, 6}
  test "1f. ", do: assert Midterm.q1({"1", "0"}) == {"1", "0"}

  test "2a. ", do: assert Midterm.q2([1, 2, 3]) == 1
  test "2b. ", do: assert Midterm.q2([1, 2, 3, 2]) == 1
  test "2c. ", do: assert Midterm.q2([1, 2, 3, 4, 3, 4, 5, 4, 4]) == 2
  test "2d. ", do: assert Midterm.q2([2, 2, 2]) == 0
  test "2e. ", do: assert Midterm.q2([2, 1, 2, 1, 2, 1, 2]) == 4
  test "2f. ", do: assert Midterm.q2([6, 5, 4, 3, 2, 3, 4, 5]) == 2
    
  test "3a. ", do: assert Midterm.q3([1, 1, 2, 2, 1, 1, 2, 2]) == [1, 2, 1, 2]
  test "3b. ", do: assert Midterm.q3([3, 3, 3, 1, 3, 3, 3 ]) == [3, 1, 3]
  test "3c. ", do: assert Midterm.q3([5, 5, 5]) == [5]
  test "3d. ", do: assert Midterm.q3([]) == []
  test "3e. ", do: assert Midterm.q3([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]
  test "3f. ", do: assert Midterm.q3([4, 5, 5, 5, 5, 5]) == [4, 5]
 
end
