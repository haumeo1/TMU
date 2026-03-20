module Lab6 (DigitalTime (..)) where

{--
    Add your functions for lab 6 below.        
    Test your code by running 'cabal test' from the lab3 directory.
--}
    
-- Modify each of the instances below so that they are implemented correctly
-- according to the description in the lab.
data DigitalTime = DigitalTime (Int, Int, Int)

normalizeTime :: (Int, Int, Int) -> (Int, Int, Int)
normalizeTime (h, m, s) = (wrapHour (h + carryH), normalizedM, normalizedS)
  where
    (carryM, normalizedS) = s `divMod` 60
    (carryH, normalizedM) = (m + carryM) `divMod` 60

    wrapHour hour
      | hour > 0 && hour `mod` 12 == 0 = 12
      | otherwise = hour `mod` 12

mkDigitalTime :: (Int, Int, Int) -> DigitalTime
mkDigitalTime = DigitalTime . normalizeTime

instance Show DigitalTime where
  show (DigitalTime (h, m, s)) = "<" ++ pad h ++ ":" ++ pad m ++ ":" ++ pad s ++ ">"
    where
      pad n
        | n >= 0 && n < 10 = '0' : show n
        | otherwise = show n

instance Eq DigitalTime where
  DigitalTime t1 == DigitalTime t2 = t1 == t2

instance Ord DigitalTime where
  DigitalTime t1 <= DigitalTime t2 = t1 <= t2

instance Num DigitalTime where
  DigitalTime (h1, m1, s1) + DigitalTime (h2, m2, s2) =
    mkDigitalTime (h1 + h2, m1 + m2, s1 + s2)

  DigitalTime (h1, m1, s1) - DigitalTime (h2, m2, s2) =
    mkDigitalTime (h1 - h2, m1 - m2, s1 - s2)

  DigitalTime (h1, m1, s1) * DigitalTime (h2, m2, s2) =
    mkDigitalTime (h1 * h2, m1 * m2, s1 * s2)

  abs (DigitalTime (h, m, s)) = mkDigitalTime (abs h, abs m, abs s)

  signum (DigitalTime (h, m, s)) = DigitalTime (signum h, signum m, signum s)

  fromInteger n = mkDigitalTime (0, 0, fromIntegral n)
