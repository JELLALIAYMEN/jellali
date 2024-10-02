import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadelComponent } from './loadel.component';

describe('LoadelComponent', () => {
  let component: LoadelComponent;
  let fixture: ComponentFixture<LoadelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoadelComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoadelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
