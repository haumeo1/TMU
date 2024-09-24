(defun my-map-into (res f a)
(dotimes (i (length a) res)
(setf (aref res i) (funcall f (aref a i)))))

(defun codec (s k)
(let* ((res (make-array (length s)))
(v (my-map-into res #'char-code s))
(ev (my-map-into res #'(lambda (x) (logxor x k)) v)))
(coerce (my-map-into res #'code-char ev) 'string)))

;;(my-map-into (make-array 4) #'(lambda (x) (* x x)) #(1 2 3 4))
;;#(1 4 9 16)
