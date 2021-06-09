//
//  ViewController.swift
//  iOS final project
//
//  Created by Wesley Monnette on 8/1/20.
//  Copyright © 2020 Wesley Monnette. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    
    var pickerData = ["3-12", "13-20", "21-35", "36-50", "51-75", "76-100"]
    var foodAmtData = ["1/3 to 1 cup", "1 to 1 1/3 cups", "1 1/3 to 2 cups", "2 to 2 2/3 cups", "2 2/3 to 3 1/3 cups", "3 1/3 to 4 cups"]
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return pickerData.count
    }
    @IBOutlet weak var weightPicker: UIPickerView!
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
    return pickerData[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        foodAmt.text = foodAmtData[row]
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        // Connects data
        weightPicker.delegate = self
        weightPicker.dataSource = self
    }
    
    @IBOutlet weak var foodAmt: UITextField!
}
