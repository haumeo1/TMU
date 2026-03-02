defmodule Segment do

  @moduledoc """
    Add your solver function below. You may add additional helper functions if you desire. 
    Test your code by running 'mix test --seed 0' from the simple_tester_ex directory.
  """

  def segment(start, finish, lines) do
    line_tuple = List.to_tuple(lines)
    suffix = suffix_sums(lines)
    n = tuple_size(line_tuple)

    case dfs(start, finish, line_tuple, suffix, n, 0, MapSet.new()) do
      {:ok, path, _} -> path
      {:error, _} -> ""
    end
  end

  defp suffix_sums(lines) do
    {rev_sums, _} =
      Enum.reduce(Enum.reverse(lines), {[0], 0}, fn len, {acc, running} ->
        new_running = running + len
        {[new_running | acc], new_running}
      end)

    List.to_tuple(rev_sums)
  end

  defp dfs(pos, finish, _, _, n, idx, dead_states) when idx == n do
    if pos == finish do
      {:ok, "", dead_states}
    else
      {:error, MapSet.put(dead_states, {idx, pos})}
    end
  end

  defp dfs(pos, finish, line_tuple, suffix, n, idx, dead_states) do
    state = {idx, pos}

    cond do
      MapSet.member?(dead_states, state) ->
        {:error, dead_states}

      not reachable_by_bounds?(pos, finish, elem(suffix, idx)) ->
        {:error, MapSet.put(dead_states, state)}

      true ->
        len = elem(line_tuple, idx)
        rem_after = elem(suffix, idx + 1)

        ordered_moves(pos, finish, len)
        |> Enum.reduce_while({:error, dead_states}, fn {dir, next_pos}, {:error, dead_acc} ->
          if reachable_by_bounds?(next_pos, finish, rem_after) do
            case dfs(next_pos, finish, line_tuple, suffix, n, idx + 1, dead_acc) do
              {:ok, suffix_path, dead_after} ->
                {:halt, {:ok, <<dir>> <> suffix_path, dead_after}}

              {:error, dead_after} ->
                {:cont, {:error, dead_after}}
            end
          else
            {:cont, {:error, dead_acc}}
          end
        end)
        |> case do
          {:ok, _, _} = ok ->
            ok

          {:error, dead_after} ->
            {:error, MapSet.put(dead_after, state)}
        end
    end
  end

  defp reachable_by_bounds?({x, y}, {fx, fy}, remaining) do
    dist = abs(x - fx) + abs(y - fy)
    dist <= remaining and rem(dist, 2) == rem(remaining, 2)
  end

  defp ordered_moves({x, y}, {fx, fy}, len) do
    [
      {?U, {x, y + len}},
      {?D, {x, y - len}},
      {?L, {x - len, y}},
      {?R, {x + len, y}}
    ]
    |> Enum.sort_by(fn {_, {nx, ny}} ->
      abs(nx - fx) + abs(ny - fy)
    end)
  end
end
