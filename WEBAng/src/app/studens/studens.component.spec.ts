import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudensComponent } from './studens.component';

describe('StudensComponent', () => {
  let component: StudensComponent;
  let fixture: ComponentFixture<StudensComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StudensComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
