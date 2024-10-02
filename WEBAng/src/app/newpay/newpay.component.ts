import {booleanAttribute, Component, OnInit} from '@angular/core';
import {Form, FormBuilder, FormGroup} from "@angular/forms";
import {setThrowInvalidWriteToSignalError} from "@angular/core/primitives/signals";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-newpay',
  templateUrl: './newpay.component.html',
  styleUrl: './newpay.component.css'
})
export class NewpayComponent implements  OnInit {
  showProgress: boolean = false;
  paymentFormGroup!: FormGroup;
  code!: String;
  pdfFileUrl!: String;

  constructor(private fb: FormBuilder, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.code = this.activatedRoute.snapshot.params['code']
    this.paymentFormGroup = this.fb.group({
      date: this.fb.control(''),
      amount: this.fb.control(''),
      modepay: this.fb.control(''), // or use an appropriate enum value if needed
      statuspay: this.fb.control(''), // or use an appropriate enum value if needed
      typepay: this.fb.control(null), // Use null or appropriate initial value
      code: this.fb.control('this.code'),
      fileSource: this.fb.control('this.code'),
      fileName: this.fb.control(''),

      // Should be fb.control instead of control
    });
  }

  selectFile(event: any) {
    if (event.target.files.length > 0) {

      let file = event.target.files[0];
      this.paymentFormGroup.patchValue({
        fileSource: file,
        fileName: file.name
      });
      this.pdfFileUrl = window.URL.createObjectURL(file);

    }
  }
  savePayment() {

    // Récupérer et formater la date au format 'yyyy-MM-dd'
    let date: Date = new Date(this.paymentFormGroup.get('date')!.value);
    let formattedDate: string = date.getFullYear() + "-" + (date.getMonth() + 1).toString().padStart(2, '0') + "-" + date.getDate().toString().padStart(2, '0');

    this.showProgress = true; // Utilisation de la propriété

    const formData: FormData = new FormData();

    formData.append('file', this.paymentFormGroup.get('fileSource')!.value);
    formData.append('date', formattedDate);
    formData.append('amount', this.paymentFormGroup.value.amount.toString());
    formData.append('modepay', this.paymentFormGroup.value.modepay.toString());
    formData.append('statuspay', this.paymentFormGroup.value.statuspay.toString());
    formData.append('typepay', this.paymentFormGroup.value.typepay.toString());

    console.log(formData);
  }
}
