//
//  ViewController.swift
//  wjm0017_lab3a
//
//  Created by Wesley Monnette on 7/12/20.
//  Copyright © 2020 Wesley Monnette. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    
    // MARK: Makes keyboard disappear
    func hideKeyboard() {
        let tap:UIGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(dismissKeyboard))
        view.addGestureRecognizer(tap)
    }
    @objc func dismissKeyboard() {
        view.endEditing(true)
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        self.hideKeyboard()
        
        // MARK: Makes picker work
        thingPicker.dataSource = self
        thingPicker.delegate = self
    }
    
    // MARK: Outlet setup
    @IBOutlet weak var thingPicker: UIPickerView!
    @IBOutlet weak var textField: UITextField!
    
    // MARK: Picker setup
    var pickerThings = ["Thing One", "Thing Two", "Thing Three"]
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return pickerThings.count
    }
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return pickerThings[row]
    }
    
    // MARK: Button action methods
    @IBAction func selectButton(_ sender: UIButton) {
        let row = thingPicker.selectedRow(inComponent: 0)
        let selected = pickerThings[row]
        let message = "You selected \(selected)"
        let alert = UIAlertController(
            title: "Selection Made",
            message: message,
            preferredStyle: .alert)
        
        let action = UIAlertAction(
            title: "Do more cool stuff!",
            style: .default,
            handler: nil)
        
        alert.addAction(action)
        present(alert, animated: true, completion: nil)
    }
    @IBAction func replaceButton(_ sender: UIButton) {
        let text = textField.text!
        pickerThings.remove(at: thingPicker.selectedRow(inComponent: 0))
        pickerThings.insert(text, at: thingPicker.selectedRow(inComponent: 0))
        
        thingPicker.reloadAllComponents()
    }
    @IBAction func insertButton(_ sender: UIButton) {
        let text = textField.text!
        pickerThings.insert(text,
            at: thingPicker.selectedRow(inComponent: 0)+1)
        thingPicker.reloadAllComponents()
        thingPicker.selectRow(thingPicker.selectedRow(inComponent: 0)+1, inComponent: 0, animated: false)
        thingPicker.reloadAllComponents()
    }
}

