import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import SelectObject from '../../components/SelectObject'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './EmployeeSalarySheet.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import EmployeeSalarySheetBase from './EmployeeSalarySheet.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
<<<<<<< HEAD

const testValues = {};
/*
const testValues = {
  baseSalary: '2813.69',
  bonus: '833.54',
  reward: '904.12',
  personalTax: '659.51',
  socialSecurity: '771.49',
  housingFound: '1093.03',
  jobInsurance: '8.44',
  employeeId: 'E000001',
  currentSalaryGradeId: 'SG000001',
=======
const {fieldLabels} = EmployeeSalarySheetBase
const testValues = {};
/*
const testValues = {
  baseSalary: '2987.06',
  bonus: '953.36',
  reward: '962.73',
  personalTax: '712.43',
  socialSecurity: '996.49',
  housingFound: '1186.07',
  jobInsurance: '6.86',
  employeeId: 'E000001',
  currentSalaryGradeId: 'SG000001',
  payingOffId: 'PO000001',
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
}
*/

const imageKeys = [
]


class EmployeeSalarySheetCreateFormBody extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
	
    
    
  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

 



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }
	
  

  render() {
    const { form, dispatch, submitting, role } = this.props
    const { convertedImagesValues } = this.state
	const userContext = null
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
<<<<<<< HEAD
    const {fieldLabels} = EmployeeSalarySheetBase
=======
    
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    const {EmployeeSalarySheetService} = GlobalComponents
    
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    
    
    const tryinit  = (fieldName) => {
      const { owner } = this.props
      if(!owner){
      	return null
      }
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      if(!owner){
      	return true
      }
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
	const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {

      labelCol: { span: 6 },
      wrapperCol: { span: 12 },

    }
    
    const internalRenderTitle = () =>{
      const linkComp=<a onClick={goback}  > <Icon type="double-left" style={{marginRight:"10px"}} /> </a>
<<<<<<< HEAD
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}工资单</div>)
=======
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('employee_salary_sheet')}</div>)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
    }
	
	return (
      <div>
        <Card title={!this.props.hideTitle&&appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>
           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.baseSalary} {...formItemLayout}>
                  {getFieldDecorator('baseSalary', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="基本工资" />
=======
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeHolder={fieldLabels.baseSalary} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.bonus} {...formItemLayout}>
                  {getFieldDecorator('bonus', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="奖金" />
=======
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeHolder={fieldLabels.bonus} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.reward} {...formItemLayout}>
                  {getFieldDecorator('reward', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="奖励" />
=======
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeHolder={fieldLabels.reward} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.personalTax} {...formItemLayout}>
                  {getFieldDecorator('personalTax', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="个人所得税" />
=======
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeHolder={fieldLabels.personalTax} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.socialSecurity} {...formItemLayout}>
                  {getFieldDecorator('socialSecurity', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="社会保险" />
=======
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeHolder={fieldLabels.socialSecurity} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.housingFound} {...formItemLayout}>
                  {getFieldDecorator('housingFound', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="住房公积金" />
=======
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeHolder={fieldLabels.housingFound} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.jobInsurance} {...formItemLayout}>
                  {getFieldDecorator('jobInsurance', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeholder="失业保险" />
=======
                    <Input size="large" prefix={`${appLocaleName(userContext,"Currency")}`} placeHolder={fieldLabels.jobInsurance} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                  )}
                </Form.Item>
              </Col>


       
 
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.employee} {...formItemLayout}>
                  {getFieldDecorator('employeeId', {
                  	initialValue: tryinit('employee'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('employee')}
                    targetType={"employee"} 
                    requestFunction={EmployeeSalarySheetService.requestCandidateEmployee}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.currentSalaryGrade} {...formItemLayout}>
                  {getFieldDecorator('currentSalaryGradeId', {
                  	initialValue: tryinit('currentSalaryGrade'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('currentSalaryGrade')}
                    targetType={"currentSalaryGrade"} 
                    requestFunction={EmployeeSalarySheetService.requestCandidateCurrentSalaryGrade}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

<<<<<<< HEAD
=======
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.payingOff} {...formItemLayout}>
                  {getFieldDecorator('payingOffId', {
                  	initialValue: tryinit('payingOff'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                  
                  <SelectObject 
                    disabled={!availableForEdit('payingOff')}
                    targetType={"payingOff"} 
                    requestFunction={EmployeeSalarySheetService.requestCandidatePayingOff}/>
                  
                 
                  )}
                </Form.Item>
              </Col>

           

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe


			 </Row>
          </Form>
        </Card>








      
       </div>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(EmployeeSalarySheetCreateFormBody))





