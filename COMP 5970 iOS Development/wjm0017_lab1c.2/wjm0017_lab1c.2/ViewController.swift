//
//  ViewController.swift
//  wjm0017_lab1c.2
//
//  Created by Wesley Monnette on 6/9/20.
//  Copyright © 2020 Wesley Monnette. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBOutlet weak var auburnView: UIImageView!
    @IBOutlet weak var ewView: UIImageView!
    @IBOutlet weak var slider: UISlider!
    
    @IBAction func logoSlider(_ sender: UISlider) {
        auburnView.alpha = 1 - CGFloat(sender.value)
        ewView.alpha = CGFloat(sender.value)
    }
}

