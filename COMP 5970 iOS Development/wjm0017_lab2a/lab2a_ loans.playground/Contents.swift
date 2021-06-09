//: A UIKit based Playground for presenting user interface
  
import UIKit
import PlaygroundSupport

class MyViewController : UIViewController {
    override func loadView() {
        let view = UIView()
        view.backgroundColor = .white

        let label = UILabel()
        label.frame = CGRect(x: 150, y: 200, width: 200, height: 20)
        label.text = "Hello World!"
        label.textColor = .black
        
        view.addSubview(label)
        self.view = view
        
        let a:Double = 150000 //Principal loan amount
        var r:Double = 0.05 //Interest rate
        let n:Double = 30 //Number of payments
        var payment:Double = 0.0
        
        r = r/12
        let onePlus = 1 + r
        let raiseN = pow(onePlus, n)
        let payD = (raiseN - 1) / (r*raiseN)
        
        payment = a / payD
        
        print(payment)
        
    }
}
// Present the view controller in the Live View window
PlaygroundPage.current.liveView = MyViewController()
