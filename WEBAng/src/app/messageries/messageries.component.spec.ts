import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageriesComponent } from './messageries.component';

describe('MessageriesComponent', () => {
  let component: MessageriesComponent;
  let fixture: ComponentFixture<MessageriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MessageriesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MessageriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
