defmodule Midterm do

  @moduledoc """
  
  FULL NAME: 
  STUDENT #: 
  
  Complete the functions below. You may overload these functions
  as you see fit, as long as they still work with the tester.

  There are also 5 multiple choice questions: mc1-mc5. These unit 
  tests will verify that you returned something between 1-5. They 
  will not mark for correctness (obviously)

  This is a mix project, just like labs 3 and 4. Run the unit tests
  using `mix test` from the directory containing mix.exs.

  Tail recursion is NOT mandatory.

  Your midterm will be marked with a fresh version of the tester, 
  with slightly different unit tests. This means that hard-coding
  for specific unit tests or modifying the tester to always pass
  will not help.
  """
  

  # There is only one multiple choice question given here, to show you
  # how they will look. The actual midterm will have 5 for each language.
  # Additionally, this practice midterm tester will mark the MC question.
  # One the real midterm, of course you won't be given tests for these.

  # Multiple Choice 1
  # Which of the following Elixir types is similar to a symbol in Smalltalk?
  # 1) atom
  # 2) boolean
  # 3) list
  # 4) tuple
  # 5) More than one of these
  def mc1 do

    3
  end

  # Coding Question 1
  # The input to this function is a pair tuple that can contain any type.
  # If both elements are numbers, the first element is 0, and the second 
  # element is non-zero, return the tuple {0, 1}. 
  # If both elements are numbers, the second element is 0, and the first
  # element is non-zero, return the tuple {1, 0}.
  # In all other cases, return the original input tuple.
  def q1({0, b}) when is_number(b) and b != 0, do: {0, 1}
  def q1({a, 0}) when is_number(a) and a != 0, do: {1, 0}
  def q1(tuple), do: tuple 


  # Coding Question 2
  # Assume the input is a list of integers. An element is considered a 
  # 'peak' if it is greater than the elements to its left and right. 
  # If there is no element to the left, the element can still be a peak 
  # if it is greater than the element to the right. The same applies if 
  # there is no element to the right. Return the number of peaks in the input.
  def q2([]), do: 0
  def q2([_]), do: 1
  def q2([a,b]) do
    if a==b do
      0
    else
      1
    end
  end 
  def q2([h|t]) do 
    if h> (hd t) do
      check(t,h,1)
    else
      check(t,h,0)
    end
  end
  defp check([],_,count), do: count
  defp check([x],temp,count) do
    if x > temp do
      check([],x,(count+1))
    else
      check([],x,count)
  end
  end
  defp check([h|t],temp,count) do
    arr = hd t
    if h > temp and h > arr do
      check(t,h,(count+1))
    else
      check(t,h,count)
    end
  end
  # Coding Question 3
  # Given an input list of positive integers, return a new list with 
  # consecutive duplicate elements removed. For example, the input list
  # [1, 1, 2, 2, 1, 1, 2, 2] would return [1, 2, 1, 2]. The input list
  # [3, 3, 3, 1, 3, 3, 3 ] would return [3, 1, 3].
  def q3([]), do: []
  def q3([h | t]) do 
    resultq3(t, h, [h])
  end
  defp resultq3([], _temp, arr) do
    Enum.reverse(arr)
  end
  defp resultq3([h | t], temp, arr) do
    if h != temp do
      resultq3(t, h, [h | arr])
    else
      resultq3(t, temp, arr)
    end
  end
end
