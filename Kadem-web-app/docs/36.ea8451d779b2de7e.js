"use strict";(self.webpackChunkmini_project=self.webpackChunkmini_project||[]).push([[36],{8036:(L,c,a)=>{a.r(c),a.d(c,{DepartementModule:()=>S});var l=a(9808),s=a(9560);class h{}var f=a(2340),e=a(1223),_=a(520);let u=(()=>{class n{constructor(t){this.httpClient=t,this.url=f.N.defaultUrl}addDepartement(t){return this.httpClient.post(this.url+"/departement/add-departement",t)}getAlldepartements(){return this.httpClient.get(this.url+"/departement/retrieve-all-departements")}updateDep(t){return this.httpClient.put(this.url+"/departement/update-departement/",t)}DeleteDep(t){return this.httpClient.delete(this.url+"/departement/remove-departement/"+t)}}return n.\u0275fac=function(t){return new(t||n)(e.LFG(_.eN))},n.\u0275prov=e.Yz7({token:n,factory:n.\u0275fac,providedIn:"root"}),n})();var m=a(2290),d=a(2382);function v(n,r){1&n&&(e.TgZ(0,"div"),e._uU(1," field is required "),e.qZA())}function b(n,r){1&n&&(e.TgZ(0,"div"),e._uU(1," minlength "),e.qZA())}function D(n,r){if(1&n&&(e.TgZ(0,"div",14),e.YNc(1,v,2,0,"div",15),e.YNc(2,b,2,0,"div",15),e.qZA()),2&n){e.oxw();const t=e.MAs(13);e.xp6(1),e.Q6J("ngIf",t.hasError("required")),e.xp6(1),e.Q6J("ngIf",t.hasError("minlength"))}}let g=(()=>{class n{constructor(t,o,i,p){this.depService=t,this.router=o,this.ActiveRoute=i,this.toastr=p}ngOnInit(){this.added=!1,this.id=this.ActiveRoute.snapshot.params.id,this.depService.getAlldepartements().subscribe({next:t=>{this.Departements=t,null!=this.Departements.find(o=>o.idDepart==this.id)?(this.dep=this.Departements.find(o=>o.idDepart==this.id),console.log("this dep :"+this.dep.idDepart),this.editmode=!0):(this.dep=new h,this.editmode=!1)},error:t=>{console.log("err : "+t)}})}canLeave(){return null==this.dep.nomDepart||0!=this.added||confirm("You have unsaved changes are you sure you wanne leave this page ?")}onSubmit(){console.log("editmode :"+this.editmode),0!=Object.keys(this.dep).length?this.editmode?(this.dep.idDepart=this.id,this.depService.updateDep(this.dep).subscribe({next:()=>{this.added=!0,this.toastr.success("departement has been updated !","Success"),this.router.navigate(["/"])},error:()=>{}})):this.depService.addDepartement(this.dep).subscribe({next:()=>{console.log("dep :"+this.dep),this.added=!0,this.toastr.success("departement has been added successfully !","Success"),this.router.navigate(["/"])},error:t=>{console.log("Error :"+t)}}):this.toastr.error("the form must be filled !","Error")}back(){this.router.navigate(["/"])}}return n.\u0275fac=function(t){return new(t||n)(e.Y36(u),e.Y36(s.F0),e.Y36(s.gz),e.Y36(m._W))},n.\u0275cmp=e.Xpm({type:n,selectors:[["app-departement-add"]],decls:21,vars:2,consts:[[1,"container-xxl","flex-grow-1","container-p-y"],[1,"row"],[1,"col-md-8"],[1,"card","mb-4"],[1,"card-header"],[1,"card-body"],["form","ngForm"],[1,"form-label"],["type","text","name","nomDepart","id","nomDepart","minlength","3","required","",1,"form-control",3,"ngModel","ngModelChange"],["nomDepart","ngModel"],["class","text-danger",4,"ngIf"],[2,"margin-top","25px"],[1,"btn","rounded-pill","btn-outline-primary",3,"click"],["routerLink","/",1,"btn","rounded-pill","btn-outline-secondary"],[1,"text-danger"],[4,"ngIf"]],template:function(t,o){if(1&t&&(e.TgZ(0,"div",0)(1,"div",1)(2,"div",2)(3,"div",3)(4,"h5",4),e._uU(5,"Add new Departement"),e.qZA(),e.TgZ(6,"div",5)(7,"form",null,6)(9,"div")(10,"label",7),e._uU(11,"Departement name"),e.qZA(),e.TgZ(12,"input",8,9),e.NdJ("ngModelChange",function(p){return o.dep.nomDepart=p}),e.qZA(),e.YNc(14,D,3,2,"div",10),e.qZA(),e.TgZ(15,"div",11)(16,"button",12),e.NdJ("click",function(){return o.onSubmit()}),e._uU(17,"Save"),e.qZA(),e._uU(18,"\xa0\xa0 "),e.TgZ(19,"button",13),e._uU(20,"Back"),e.qZA()()()()()()()()),2&t){const i=e.MAs(13);e.xp6(12),e.Q6J("ngModel",o.dep.nomDepart),e.xp6(2),e.Q6J("ngIf",i.invalid&&i.touched)}},directives:[d._Y,d.JL,d.F,d.Fj,d.wO,d.Q7,d.JJ,d.On,l.O5,s.rH],styles:[""]}),n})();function x(n,r){if(1&n){const t=e.EpF();e.TgZ(0,"div",2)(1,"table",3)(2,"thead")(3,"tr")(4,"th"),e._uU(5,"Departement's name"),e.qZA(),e._UZ(6,"th"),e.TgZ(7,"th"),e._uU(8,"Actions"),e.qZA()()(),e.TgZ(9,"tbody",4)(10,"tr")(11,"td"),e._uU(12),e.qZA(),e._UZ(13,"td"),e.TgZ(14,"td")(15,"button",5),e.NdJ("click",function(){e.CHM(t);const i=e.oxw();return i.gotoedit(i.dep)}),e._UZ(16,"i",6),e._uU(17," Edit"),e.qZA(),e._uU(18," \xa0 "),e.TgZ(19,"button",7),e._UZ(20,"i",8),e._uU(21," Delete "),e.qZA(),e.TgZ(22,"div",9)(23,"div",10)(24,"div",11)(25,"div",12)(26,"h5",13),e._uU(27,"Confirmation panel"),e.qZA(),e._UZ(28,"button",14),e.qZA(),e.TgZ(29,"div",15),e._uU(30,"Are you sure you want to delete ? "),e.qZA(),e.TgZ(31,"div",16)(32,"button",17),e.NdJ("click",function(){return e.CHM(t),e.oxw().notifyDelete()}),e._uU(33," Yes "),e.qZA(),e.TgZ(34,"button",18),e._uU(35," No "),e.qZA()()()()()()()()()()}if(2&n){const t=e.oxw();e.xp6(12),e.Oqu(t.dep.nomDepart)}}function Z(n,r){1&n&&(e.TgZ(0,"div",19)(1,"div",20)(2,"div",21)(3,"div",22),e._uU(4," No records found "),e.qZA()()()())}let A=(()=>{class n{constructor(t){this.router=t,this.notification=new e.vpe}ngOnInit(){}notifyDelete(){this.notification.emit(this.dep)}gotoedit(t){this.router.navigate(["/update",t.idDepart])}}return n.\u0275fac=function(t){return new(t||n)(e.Y36(s.F0))},n.\u0275cmp=e.Xpm({type:n,selectors:[["app-departement-list"]],inputs:{dep:"dep",SearchedDep:"SearchedDep"},outputs:{notification:"notification"},decls:3,vars:2,consts:[["class","table-responsive text-nowrap",4,"ngIf","ngIfElse"],["elseBlock",""],[1,"table-responsive","text-nowrap"],[1,"table","table-hover"],[1,"table-border-bottom-0"],[1,"btn","rounded-pill","btn-outline-warning",3,"click"],[1,"bx","bx-edit-alt","me-1"],["type","button","data-bs-toggle","modal","data-bs-target","#modalToggle",1,"btn","rounded-pill","btn-outline-danger"],[1,"bx","bx-trash","me-1"],["id","modalToggle","aria-labelledby","modalToggleLabel","tabindex","-1","aria-hidden","true",1,"modal","fade",2,"display","none"],[1,"modal-dialog","modal-dialog-centered"],[1,"modal-content"],[1,"modal-header"],["id","modalToggleLabel",1,"modal-title"],["type","button","data-bs-dismiss","modal","aria-label","Close",1,"btn-close"],[1,"modal-body"],[1,"modal-footer"],["data-bs-dismiss","modal",1,"btn","rounded-pill","btn-success",3,"click"],["data-bs-dismiss","modal",1,"btn","rounded-pill","btn-secondary"],[1,"container","fluid"],[2,"margin-top","30px","margin-bottom","30px"],[1,"alert","alert-danger"],[1,"d-flex","justify-content-center"]],template:function(t,o){if(1&t&&(e.YNc(0,x,36,1,"div",0),e.YNc(1,Z,5,0,"ng-template",null,1,e.W1O)),2&t){const i=e.MAs(2);e.Q6J("ngIf",o.dep.nomDepart==o.SearchedDep||""==o.SearchedDep||null==o.SearchedDep)("ngIfElse",i)}},directives:[l.O5],styles:["table[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]   td[_ngcontent-%COMP%]:empty{width:600px}table[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]   td[_ngcontent-%COMP%]{padding-top:10px;padding-bottom:10px}"]}),n})();function C(n,r){if(1&n){const t=e.EpF();e.TgZ(0,"app-departement-list",13),e.NdJ("notification",function(i){const U=e.CHM(t).index;return e.oxw().deleteDepart(i,U)}),e.qZA()}if(2&n){const t=r.$implicit,o=e.oxw();e.Q6J("SearchedDep",o.departSearch)("dep",t)}}const y=function(){return{standalone:!0}},T=[{path:"update/:id",component:g},{path:"addDepartement",component:g},{path:"",component:(()=>{class n{constructor(t,o,i){this.depService=t,this.router=o,this.toastr=i}ngOnInit(){this.depService.getAlldepartements().subscribe({next:t=>{this.listdep=t},error:t=>{console.log("err :"+t)}})}deleteDepart(t,o){this.depService.DeleteDep(t.idDepart).subscribe({next:()=>{this.listdep.splice(o,1),this.toastr.success("departement has been deleted successfully","Success")},error:i=>{console.log("err"+i),this.toastr.error("something went wrong !","Error")}})}gotoadd(){this.router.navigate(["/addDepartement"])}}return n.\u0275fac=function(t){return new(t||n)(e.Y36(u),e.Y36(s.F0),e.Y36(m._W))},n.\u0275cmp=e.Xpm({type:n,selectors:[["app-parent-list"]],decls:15,vars:4,consts:[[1,"container","fluid"],[1,"d-flex","justify-content-end","m-2"],[1,"d-flex"],[1,"input-group"],[1,"input-group-text"],[1,"tf-icons","bx","bx-search"],["type","text","placeholder","Search...",1,"form-control",3,"ngModel","ngModelOptions","ngModelChange"],["type","button","routerLink","/addDepartement",1,"btn","btn-primary"],[1,"bx","bx-add-to-queue"],[1,"container-xxl","flex-grow-1","container-p-y"],[1,"row"],[1,"card"],[3,"SearchedDep","dep","notification",4,"ngFor","ngForOf"],[3,"SearchedDep","dep","notification"]],template:function(t,o){1&t&&(e.TgZ(0,"div",0)(1,"div",1)(2,"form",2)(3,"div",3)(4,"span",4),e._UZ(5,"i",5),e.qZA(),e.TgZ(6,"input",6),e.NdJ("ngModelChange",function(p){return o.departSearch=p}),e.qZA()()(),e._uU(7,"\xa0\xa0 "),e.TgZ(8,"button",7),e._UZ(9,"i",8),e._uU(10,"Add"),e.qZA()()(),e.TgZ(11,"div",9)(12,"div",10)(13,"div",11),e.YNc(14,C,1,2,"app-departement-list",12),e.qZA()()()),2&t&&(e.xp6(6),e.Q6J("ngModel",o.departSearch)("ngModelOptions",e.DdM(3,y)),e.xp6(8),e.Q6J("ngForOf",o.listdep))},directives:[d._Y,d.JL,d.F,d.Fj,d.JJ,d.On,s.rH,l.sg,A],styles:[""]}),n})()}];let M=(()=>{class n{}return n.\u0275fac=function(t){return new(t||n)},n.\u0275mod=e.oAB({type:n}),n.\u0275inj=e.cJS({imports:[[s.Bz.forChild(T)],s.Bz]}),n})(),S=(()=>{class n{}return n.\u0275fac=function(t){return new(t||n)},n.\u0275mod=e.oAB({type:n}),n.\u0275inj=e.cJS({imports:[[l.ez,M,d.u5]]}),n})()}}]);