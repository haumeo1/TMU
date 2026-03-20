module Main where
    import Test.HUnit
    import qualified Lab6
    import qualified System.Exit as Exit

    main = do
         status <- runTestTT all_tests
         if failures status > 0 || errors status > 0 then Exit.exitFailure else Exit.exitSuccess

-- run tests with:
--     cabal test

    time_t1 = TestCase (assertEqual "time_t1 show()" "<09:22:04>" (show $ Lab6.DigitalTime (9, 22, 4)))
    time_t2 = TestCase (assertEqual "time_t2 (==)" False (Lab6.DigitalTime (12, 59, 59) == Lab6.DigitalTime (11, 58, 58)))
    time_t3 = TestCase (assertEqual "time_t3 (==)" True (Lab6.DigitalTime (1, 5, 5) == Lab6.DigitalTime (1, 5, 5)))
    time_t4 = TestCase (assertEqual "time_t4 (<=)" False (Lab6.DigitalTime (9, 2, 5) <= Lab6.DigitalTime (4, 3, 2)))
    time_t5 = TestCase (assertEqual "time_t5 (<=)" True (Lab6.DigitalTime (12, 59, 58) <= Lab6.DigitalTime (12, 59, 59)))
    time_t6 = TestCase (assertEqual "time_t6 (+)" (Lab6.DigitalTime (5, 5, 5)) (Lab6.DigitalTime (2, 2, 2) + Lab6.DigitalTime (3, 3, 3)))
    time_t7 = TestCase (assertEqual "time_t7 (-)" (Lab6.DigitalTime (5, 5, 5)) (Lab6.DigitalTime (8, 8, 8) - Lab6.DigitalTime (3, 3, 3)))
    time_t8 = TestCase (assertEqual "time_t8 fromInteger()" (Lab6.DigitalTime (5, 5, 5)) (Lab6.DigitalTime (5, 5, 1) + 4))

    all_tests = TestList [ time_t1, time_t2, time_t3, time_t4, time_t5, time_t6, time_t7, time_t8 ]


