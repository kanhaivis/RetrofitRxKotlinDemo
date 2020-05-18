package ns.api

interface RequestCallback<T> {
     fun onNext(t: T)
     fun onError(str: String)
     fun onComplete(str: String)
}