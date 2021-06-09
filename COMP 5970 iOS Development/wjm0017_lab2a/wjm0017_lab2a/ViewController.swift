//
//  ViewController.swift
//  wjm0017_lab2a
//
//  Created by Wesley Monnette on 6/21/20.
//  Copyright © 2020 Wesley Monnette. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        }

    @IBOutlet weak var amount: UITextField!
    @IBOutlet weak var numPayments: UITextField!
    @IBOutlet weak var rate: UITextField!
    @IBOutlet weak var paymentLabel: UILabel!
    var payment:Double = 0.0
    var iRate:Double = 0.0
    
    @IBAction func paymentButton(_ sender: UIButton) {
        let a = Double(amount.text!)!
        let n = Double(numPayments.text!)!
        var r = (rate.text! as NSString).floatValue
        
        if (r < 5) {
            r = r / 12
        }
        
        iRate = Double(r / 100)
        let onePlus = 1 + iRate
        let raiseN = pow(onePlus, n)
        let payD = (raiseN - 1) / (iRate * raiseN)
        payment = a / payD
        
        paymentLabel.text = String(Double(payment))
    }
}
