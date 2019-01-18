## Circuit Breaker Example

https://www.youtube.com/watch?v=FWP52PcdpAw

This application simply shouts "Cheese!" or "PETRILL!!" at you to 
demonstrate the circuit breaker pattern. 

In this example "Cheese!" is considered to be a successful response
from a protected resource with "PETRILL!!" being unsuccessful. 

The threshold for error is currently set to 2 attempts, so 2 failed 
responses will result in the breaker tripping and closing. After 5 
seconds the breaker will half open for one request. 

If this request is unsuccessful then the breaker will close again, 
otherwise it will re-open. 

