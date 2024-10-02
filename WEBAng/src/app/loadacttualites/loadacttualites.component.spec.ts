import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadacttualitesComponent } from './loadacttualites.component';

describe('LoadacttualitesComponent', () => {
  let component: LoadacttualitesComponent;
  let fixture: ComponentFixture<LoadacttualitesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoadacttualitesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoadacttualitesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
